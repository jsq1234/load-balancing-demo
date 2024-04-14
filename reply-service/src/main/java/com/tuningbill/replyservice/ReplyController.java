package com.tuningbill.replyservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tuningbill.replyservice.dto.ReplyBody;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor    
public class ReplyController {
    private final ReplyService replyService;

    @GetMapping("/replies")
    public List<Reply> getRepliesByPostId(@RequestParam("postId") Long postId) {
        return replyService.getRepliesByPostId(postId);
    }

    @PostMapping("/{postId}")
    public ResponseEntity<Reply> createReply(@PathVariable(name = "postId") Long postId, @RequestBody ReplyBody replyBody) {
        Reply reply = Reply.builder()
                            .postId(postId)
                            .content(replyBody.content())
                            .build();
        return ResponseEntity.ok(replyService.createReply(reply));
    }
}
