package is.hi.memos.Controllers;

import is.hi.memos.Persistence.Entities.Memo;
import is.hi.memos.Services.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HomeController {
    private MemoService memoService;

    @Autowired
    public HomeController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping("/")
    public String homePage(Model model) {

        List<Memo> allMemos = memoService.findAll();
        model.addAttribute("memos", allMemos);

        return "home";
    }

    @GetMapping("/newMemo")
    public String newMemoGET(Model model){
        return "newMemo";
    }

    @PostMapping("/newMemo")
    public String newMemoPost(Memo memo, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "newMemo";
        }
        memoService.save(memo);

        return "redirect:/";
    }

    @GetMapping("/viewMemo/{id}")
    public String memoGET(@PathVariable("id") long id, Model model){
        model.addAttribute("memos", memoService.findByID(id));

        return "viewMemo";
    }
}
