package io.github.microservice.components.user.rest

import com.baomidou.mybatisplus.plugins.Page
import io.github.microservice.components.user.model.UserAccount
import io.github.microservice.components.user.service.UserAccountService
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

/**
 * Rest controller. UserAccount
 */
@RestController
@RequestMapping("/api")
class UserAccountResource(private val service: UserAccountService) {

    private final val log = LoggerFactory.getLogger(javaClass)

    /**
     * Get /user_account : Create a new user_account
     *
     * @param userAccount the user_account to create
     * @return the ResponseEntity with status 200 (OK) and with body the new userAccount
     */
    @PostMapping("/user_account")
    fun createUserAccount(@Valid @RequestBody userAccount: UserAccount): ResponseEntity<UserAccount> {
        log.debug("REST request to save UserAccount : {}", userAccount)
        service.insert(userAccount)
        return ResponseEntity.ok(userAccount)
    }

    /**
     * PUT /user_account : Updates an existing user_account
     *
     * @param userAccount the user_account to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated user_account
     */
    @PutMapping("/user_account")
    fun updateUserAccount(@Valid @RequestBody userAccount: UserAccount): ResponseEntity<UserAccount> {
        log.debug("REST request to update UserAccount : {}", userAccount)
        service.updateById(userAccount)
        return ResponseEntity.ok(userAccount)
    }

    /**
     * GET /user_account : get all user_account.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all user_account
     */
    @GetMapping("/user_account")
    @ApiOperation(value = "get all user_account.", response = Page::class)
    fun getAllUserAccount(@ApiParam pageable: Page<UserAccount>): ResponseEntity<Page<UserAccount>> {
        val page = service.selectPage(pageable)
        return ResponseEntity.ok(page)
    }

    /**
     * GET /user_account/info : get the "id" user_account
     *
     * @param id the id of the user_account to find
     * @return
     */
    @GetMapping("/user_account/info")
    @ApiOperation(value = "get the \"id\" user_account", response = UserAccount::class)
    fun getUserAccount(@RequestParam id: Int?): ResponseEntity<UserAccount> {
        log.debug("REST request to get UserAccount : {}", id)
        val entity = service.selectById(id)
        return ResponseEntity.ok(entity)
    }

    /**
     * DELETE /user_account : delete the "id" user_account.
     *
     * @param id the id of the user_account to delete
     * @return
     */
    @DeleteMapping("/user_account")
    fun deleteUserAccount(@RequestParam id: Int?) {
        log.debug("REST request to delete UserAccount : {}", id)
        service.deleteById(id)
    }
}
