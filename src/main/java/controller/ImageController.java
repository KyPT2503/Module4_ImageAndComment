package controller;

import model.Comment;
import model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.comment.ICommentService;
import service.image.IImageService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private IImageService imageService;
    @Autowired
    private ICommentService commentService;
    @Autowired
    private Environment environment;

    @ModelAttribute("levers")
    public List<Integer> getLever() {
        return new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    }

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
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("image", imageService.getById(id));
        modelAndView.addObject("comments", commentService.getByImageId(id));
        modelAndView.addObject("comment", new Comment());
        return modelAndView;
    }
}
