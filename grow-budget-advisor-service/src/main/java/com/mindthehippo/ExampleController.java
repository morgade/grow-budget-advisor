package com.mindthehippo;

import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Marcelo
 */
@RestController
public class ExampleController {
//    @Autowired
//    private CommentRepository commentRepository;
//    
//    @RequestMapping("/heap")
//    public Map heap() {
//        return new HashMap() {{
//            put("max", Runtime.getRuntime().maxMemory());
//            put("free", Runtime.getRuntime().freeMemory());
//        }};
//    }
//    
//    @RequestMapping(value = "/comment", method = RequestMethod.POST)
//    public void postComment(@RequestBody Comment comment) throws InterruptedException {
//        Thread.sleep(1000);
//        commentRepository.save(comment);
//    }
//    
//    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
//    public void delete(@PathVariable("id") String commentId) throws InterruptedException {
//        Thread.sleep(1000);
//        commentRepository.remove(commentId);
//    }
//    
//    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
//    public Comment get(@PathVariable("id") String commentId) throws InterruptedException {
//        Thread.sleep(1000);
//        return commentRepository.get(commentId);
//    }
//    
//    @RequestMapping(value = "/comment", method = RequestMethod.GET)
//    public Iterable<Comment> getComments() throws InterruptedException {
//        Thread.sleep(1000);
//        return commentRepository.findAll();
//    }
}
