package flow.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : LiuYong at 2020-08-13
 * @package: com.techwolf.oceanus.moss.web.flow.domain
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
public class GraphInfo {
  private int id;
  private String name;
  private String scene;
  private String version;
  private String desc;
}
