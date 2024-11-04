package com.blog.innofree.dto.article;

import com.blog.innofree.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String title;
    private String content;

    public Article toEntity(String author) {

        return Article.builder().title(title).content(content).author(author).build();
    }
}
