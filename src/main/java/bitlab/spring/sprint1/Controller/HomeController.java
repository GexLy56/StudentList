package bitlab.spring.sprint1.Controller;


import bitlab.spring.sprint1.db.DBManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model) {
        model.addAttribute("students", DBManager.getStudents());
        return "index";
    }

    @GetMapping(value = "/addStudent")
    public String addPage() {
        return "add_page";
    }

    @PostMapping(value = "/addStudent")
    public String AddStudent(@RequestParam(name = "name") String name,
                             @RequestParam(name = "surname") String surname,
                             @RequestParam(name = "exam") int exam) {
        DBManager.addStudent(name, surname, exam);
        return "redirect:/";
    }
}
