package org.ruoxue.spring_boot_168.game.ggg.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GggReponse {
	/** 錯誤碼 */
	private int errorCode;
	/** Token */
	private String token;
	/** 名稱 */
	private String name;
	/** 是否存在 */
	private boolean exist;

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		builder.appendSuper(super.toString());
		builder.append("errorCode", errorCode);
		builder.append("token", token);
		builder.append("name", name);
		builder.append("exist", exist);
		return builder.toString();
	}
}
