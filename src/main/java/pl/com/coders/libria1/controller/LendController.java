
package pl.com.coders.libria1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.com.coders.libria1.controller.request.LendRequest;
import pl.com.coders.libria1.controller.request.ReturnRequest;
import pl.com.coders.libria1.domain.Lend;
import pl.com.coders.libria1.service.LendService;

@RestController
@RequestMapping("/lend")
public class LendController {

    @Autowired
    private LendService lendService;

    @PostMapping()
    public Lend lendBook(@RequestBody LendRequest lendRequest) {
        return lendService.lendBook(lendRequest);
    }

    @PostMapping("/return")
    public Lend returnBook(@RequestBody ReturnRequest returnRequest) {
        return lendService.returnBook(returnRequest);
    }

}


