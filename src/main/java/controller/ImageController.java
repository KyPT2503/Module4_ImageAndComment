package controller;

import model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.image.IImageService;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IImageService imageService;
    @Autowired
    private Environment environment;

    @GetMapping("/create")
    public ModelAndView showCreate() {
        return new ModelAndView("create", "image", new Image());
    }

    @PostMapping("/create")
    public ModelAndView create(@ModelAttribute("image") Image image) throws IOException {
        image.setSrc(image.getFile().getOriginalFilename());
        FileCopyUtils.copy(image.getFile().getBytes(), new File(environment.getProperty("file_upload") + image.getSrc()));
        int id = imageService.addAndGetId(image);
        return new ModelAndView("redirect:" + id);
    }

    @GetMapping("/{id}")
    public ModelAndView showImage(@PathVariable int id) {
        return new ModelAndView("show", "image", imageService.getById(id));
    }
}
