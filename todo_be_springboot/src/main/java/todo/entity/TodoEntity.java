package todo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_todolist")
@NoArgsConstructor
@AllArgsConstructor
@Data
@DynamicUpdate
public class TodoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer todoIdx;
	
	@Column(nullable=true)
	private String todoContent;
	
	@UpdateTimestamp
	@Column(nullable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm", timezone = "Asia/Seoul")
	private LocalDateTime todoUpdatedDatetime;
	
	@CreationTimestamp
	@Column(nullable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd HH:mm", timezone = "Asia/Seoul")
	private LocalDateTime todoCreatedDatetime;
	
	@Column(nullable=true)
	private Boolean todoImportant;
	
	@Column(nullable=true)
	private Boolean todoCompleted;
}
