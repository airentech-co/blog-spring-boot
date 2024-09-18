package dev.airentech.blog.service;

import dev.airentech.blog.model.Post;
import dev.airentech.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepo;

    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Optional<Post> getPostById(Long id) {
        return postRepo.findById(id);
    }

    public Post updatePost(Long id, Post post) {
        if (postRepo.existsById(id)) {
            post.setId(id);
            return postRepo.save(post);
        } else {
            return null;
        }
    }

    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }

}
