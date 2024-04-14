package com.tuningbill.postservice;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post updatePost(Long id, Post post) {
        Post existingPost = postRepository.findById(id).orElse(null);
        if (existingPost == null) {
            return null;
        }
        existingPost.setTitle(post.getTitle());
        existingPost.setContent(post.getContent());
        return postRepository.save(existingPost);
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
