package org.ruoxue.spring_boot_168.game.ggg.model;

import java.util.ArrayList;
import java.util.List;

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
public class GggListReponse {
	/** 錯誤碼 */
	private int errorCode;
	/** 名稱 */
	private List<String> names = new ArrayList<String>();

	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		builder.appendSuper(super.toString());
		builder.append("errorCode", errorCode);
		builder.append("names", names);
		return builder.toString();
	}
}
