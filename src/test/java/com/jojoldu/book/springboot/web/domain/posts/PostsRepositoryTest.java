package com.jojoldu.book.springboot.web.domain.posts;

import static org.assertj.core.api.Java6Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jojoldu.book.springboot.domain.posts.Posts;
import com.jojoldu.book.springboot.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;

	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Test
	public void 게시글저장_불러오기() {
		String title = "테스트 게시글";
		String content = "테스트 본문";

		postsRepository.save(Posts.builder()
			.title(title)
			.content(content)
			.author("jnsorn@gmail.com")
			.build());

		List<Posts> postss501 = postsRepository.findAll();

		Posts posts = postss501.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}

	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now = LocalDateTime.of(2019, 6, 4, 0, 0, 0);
		postsRepository.save(Posts.builder()
			.title("title")
			.content("content")
			.author("author")
			.build());
		//when
		List<Posts> postsList = postsRepository.findAll();

		//then
		Posts posts = postsList.get(0);

		System.out.println(
			">>>>>>>>> createDate=" + posts.getCreatedDate() + ", modifiedDate=" + posts.getModifiedDate());
/* NOTE : isAfter.. */

/*		assertThat(posts.getCreatedDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);*/
	}

}
