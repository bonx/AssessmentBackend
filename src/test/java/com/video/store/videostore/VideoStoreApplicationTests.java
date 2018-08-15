package com.video.store.videostore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.video.store.app.VideoStoreApplication;



@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={VideoStoreApplication.class})
@PropertySource("classpath*:application-test.properties")
public class VideoStoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
