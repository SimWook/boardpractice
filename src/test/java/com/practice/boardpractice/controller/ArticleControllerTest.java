package com.practice.boardpractice.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled("作成中")
@DisplayName("View Controller: Article")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {
    private final MockMvc mockMvc;

    public ArticleControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @DisplayName("[view][GET] 掲示板リストページ - 正常パターン")
    @Test
    public void get_article_list_success() throws Exception {
        mockMvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("article"));
    }

    @DisplayName("[view][GET] 掲示板1件取得ページ - 正常パターン")
    @Test
    public void get_article_one_success() throws Exception {
        mockMvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));
    }

    @DisplayName("[view][GET] 掲示板検索ページ - 正常パターン")
    @Test
    public void get_article_list_search() throws Exception {
        mockMvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search"));
    }

    @DisplayName("[view][GET] 掲示板ハッシュタグ検索ページ - 正常パターン")
    @Test
    public void get_article_list_hashtag() throws Exception {
        mockMvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles/search-hashtag"));
    }
}