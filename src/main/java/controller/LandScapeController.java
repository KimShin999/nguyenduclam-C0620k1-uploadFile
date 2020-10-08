package controller;

import Model.LandScape;
import Model.LandScapeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.LandScape.ILanScapeService;

import java.io.File;
import java.io.IOException;

@Controller
public class LandScapeController {
    @Autowired
    private Environment environment;

    @Autowired
    private ILanScapeService lanScapeService;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("list");
        mav.addObject("list", lanScapeService.findAll());
        return mav;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("landScape", new LandScapeForm());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute LandScapeForm landScapeForm){
        //1 gan student nhung thuoc tinh cua landScapeForm
        LandScape landScape = new LandScape(landScapeForm.getName(), landScapeForm.getCountry());
        MultipartFile file = landScapeForm.getImage();
        String image = file.getOriginalFilename();
        landScape.setImage(image);
        String fileUpload = environment.getProperty("file_upload").toString();
        try {
            FileCopyUtils.copy(file.getBytes(), new File(fileUpload + image));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lanScapeService.save(landScape);
        return new ModelAndView("create", "landScape", new LandScapeForm());

    }
}
