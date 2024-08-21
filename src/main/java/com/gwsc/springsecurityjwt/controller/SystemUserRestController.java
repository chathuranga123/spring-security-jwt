package com.gwsc.springsecurityjwt.controller;



import com.gwsc.springsecurityjwt.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(path = "/system-users")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class SystemUserRestController {

    private UserService userService;
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getReferenceData() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersByUsername("admin",false));
    }

    /*@GetMapping(value = "/search-reference-data", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getReferenceData() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getReferenceData("username"));
    }

    @GetMapping(value = "/", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> getUsers(
            @RequestParam(required = false) Integer start,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) String order,
            @RequestParam(required = false) String all,
            @RequestParam(required = false) String statusCode,
            @RequestParam(required = false) String systemUsername,
            @RequestParam(required = false) Boolean full,
            @RequestParam(required = false) Boolean dataTable,
            @RequestParam(required = false) Integer draw) {
        Map<String, Object> map = new HashMap<>();
        map.put("start", start);
        map.put("limit", limit);
        map.put("sortBy", sortBy);
        map.put("order", order);
        map.put("all", all);
        map.put("statusCode", statusCode);
        map.put("systemUserName", systemUsername);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers(map, full, dataTable, draw));
    }

    @PostMapping(
            value = "/",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    public ResponseEntity<Object> saveUser(@RequestBody UserDTO userDTO, @RequestParam(value = "username") String username) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(userDTO, username));
    }*/
}
