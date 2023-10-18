package entity;

import lombok.Data;

@Data
public class Log {
    int id;
    String ip;
    String file_name;
    String file_type;
    Long file_size;
    String upload_time;
}
