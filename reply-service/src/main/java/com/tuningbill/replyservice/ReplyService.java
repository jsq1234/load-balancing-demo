package com.tuningbill.replyservice;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;

    public Reply createReply(Reply reply) {
        return replyRepository.save(reply);
    }

    public Reply getReply(Long id) {
        return replyRepository.findById(id).orElse(null);
    }

    public void deleteReply(Long id) {
        replyRepository.deleteById(id);
    }

    public Reply updateReply(Long id, Reply reply) {
        Reply existingReply = replyRepository.findById(id).orElse(null);
        if (existingReply == null) {
            return null;
        }
        existingReply.setContent(reply.getContent());
        return replyRepository.save(existingReply);
    }

    public List<Reply> getRepliesByPostId(Long postId) {
        return replyRepository.findByPostId(postId);
    }
}
