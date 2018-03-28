package io.github.microservice.components.user.rest;

import com.baomidou.mybatisplus.plugins.Page;
import io.github.microservice.components.user.model.UserAccount;
import io.github.microservice.components.user.service.UserAccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Rest controller. UserAccount
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UserAccountResource {

    private final UserAccountService service;

    public UserAccountResource(UserAccountService service) {
        this.service = service;
    }

    /**
     * Get /user_account : Create a new user_account
     *
     * @param userAccount the user_account to create
     * @return the ResponseEntity with status 200 (OK) and with body the new userAccount
     */
    @PostMapping("/user_account")
    public ResponseEntity<UserAccount> createUserAccount(@Valid @RequestBody UserAccount userAccount) {
        log.debug("REST request to save UserAccount : {}", userAccount);
        service.insert(userAccount);
        return ResponseEntity.ok(userAccount);
    }

    /**
     * PUT /user_account : Updates an existing user_account
     *
     * @param userAccount the user_account to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated user_account
     */
    @PutMapping("/user_account")
    public ResponseEntity<UserAccount> updateUserAccount(@Valid @RequestBody UserAccount userAccount) {
        log.debug("REST request to update UserAccount : {}", userAccount);
        service.updateById(userAccount);
        return ResponseEntity.ok(userAccount);
    }

    /**
     * GET /user_account : get all user_account.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all user_account
     */
    @SuppressWarnings("unchecked")
    @GetMapping("/user_account")
    @ApiOperation(value = "get all user_account.", response = Page.class)
    public ResponseEntity<Page<UserAccount>> getAllUserAccount(@ApiParam Page pageable) {
        final Page<UserAccount> page = service.selectPage(pageable);
        return ResponseEntity.ok(page);
    }

    /**
     * GET /user_account/info : get the "id" user_account
     *
     * @param id the id of the user_account to find
     * @return
     */
    @GetMapping("/user_account/info")
    @ApiOperation(value = "get the \"id\" user_account", response = UserAccount.class)
    public ResponseEntity<UserAccount> getUserAccount(@RequestParam Integer id) {
        log.debug("REST request to get UserAccount : {}", id);
        UserAccount entity = service.selectById(id);
        return ResponseEntity.ok(entity);
    }

    /**
     * DELETE /user_account : delete the "id" user_account.
     *
     * @param id the id of the user_account to delete
     * @return
     */
    @DeleteMapping("/user_account")
    public void deleteUserAccount(@RequestParam Integer id) {
        log.debug("REST request to delete UserAccount : {}", id);
        service.deleteById(id);
    }
}
