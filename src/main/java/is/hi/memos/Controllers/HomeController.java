package is.hi.memos.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class HomeController
{
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String HomeController()
    {
        return "home";
    }

    @RequestMapping(value = "/memo/{id}", method = RequestMethod.GET)
    public String memoGET(Model model){

        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("YY:MM:dd | hh:mm:ss");
        model.addAttribute("lastSaved", timeFormat.format(currentDate));
        return "memo";
    }
}
