package org.crazyit.cloud;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: xyy
 * @Date: 2020/1/3 15:38
 */
@RestController
public class MyController {
    @RequestMapping(value = "/person/{personId}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(@PathVariable("personId") Integer personId,
                             HttpServletRequest request) {
        Person p = new Person();
        p.setId(personId);
        p.setName("Crazyit");
        p.setAge(30);
        p.setMessage(request.getRequestURL().toString());
        return p;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }
}
