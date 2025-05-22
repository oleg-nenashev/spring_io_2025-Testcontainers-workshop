package com.example.todos.ai;

import com.example.todos.hn.HackernewsItem;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Service class for AI-related functionality.
 * This class provides methods for interacting with the OpenAI API.
 */
@Service
public class AiService {

    ChatClient newsAssistant;

    public AiService(ChatClient newsAssistant) {
        this.newsAssistant = newsAssistant;
    }

    public HackernewsItemResult assess(HackernewsItem item) {
        newsAssistant.prompt().user(u ->u.text("Hacker News Item: is {item}").param("item", item))
                .call().entity(HackernewsItemResult.class);
        return null;
    }

}

@Configuration
class ConversationalConfiguration {

    @Bean
    ChatClient chatClient(ChatClient.Builder builder) {

        var system = """
                You are an AI assistant that processes Hacker News articles to help users quickly understand and prioritize them.
                
                 Given the following article metadata:
                 ID: {id} 
                 Title: {title}
                 URL: {url} 
                 Author: {by} 
                 Timestamp: {time}
                 Number of Comments: {descendants}
                 Perform the following:
    
                 Summary: Provide a concise summary of what this article is about, based on the title and context.
    
                 Priority: Estimate how important or relevant this article might be to a general tech-savvy user (low / medium / high). Use title content and comment volume as signals.
    
                 Time Estimate: Estimate how long it might take to read and understand the article  together with the comments (e.g., "2 min", "5-7 min").
    
                 Sentiment: Predict the likely sentiment of the article and its discussion (positive / negative / neutral). Use comment count and title tone as clues.
    
                 Respond in JSON format like:
                 {
                   "summary": "...",
                   "priority": "high",
                   "time_estimate": "5-7 min",
                   "sentiment": "neutral"
                 }
                """;
        return builder
                .defaultSystem(system)
                .build();
    }

}

