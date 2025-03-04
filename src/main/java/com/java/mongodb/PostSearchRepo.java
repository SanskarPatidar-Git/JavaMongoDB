package com.java.mongodb;

import java.util.List;

public interface PostSearchRepo {

	List<PostDto> search(String text);
}
