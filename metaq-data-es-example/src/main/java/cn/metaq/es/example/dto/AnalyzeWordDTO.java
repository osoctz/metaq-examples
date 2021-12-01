package cn.metaq.es.example.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * { "tokens": [ { "token": "巨人", "start_offset": 0, "end_offset": 2, "type": "CN_WORD", "position": 0 }, { "token":
 * "蔡", "start_offset": 2, "end_offset": 3, "type": "CN_CHAR", "position": 1 }, { "token": "英文", "start_offset": 3,
 * "end_offset": 5, "type": "CN_WORD", "position": 2 }, { "token": "香港", "start_offset": 5, "end_offset": 7, "type":
 * "CN_WORD", "position": 3 } ] }
 */
@Getter
@Setter
public class AnalyzeWordDTO {

  private List<Word> tokens;

  @Setter
  @Getter
  public static class Word {

    private String token;
    private Integer startOffset;
    private Integer endOffset;
    private String type;
    private Integer position;
  }
}
