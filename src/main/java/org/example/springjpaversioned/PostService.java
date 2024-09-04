package org.example.springjpaversioned;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {


    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public void setupBd(){
        for (long i = 1; i <= 8; i++) {
            postRepository.save(
                    new Post()
                            .setId(i)
                            .setTitle(String.format("Spam post %d", i))
            );
        }
        postRepository.allPosts().forEach(System.out::println);
    }

    public void testBulkUpdate() {
        System.out.println("====== test bulk update =====");
        postRepository.bulkPostsUpdate(PostStatus.SPAM, PostStatus.PENDING, "%spam%", "Rejected Spam");
        postRepository.allPosts().forEach(System.out::println);
        System.out.println("===================");
    }

    ;
}
