package com.javaweb.vo;

import java.io.Serializable;

public class AutoPaper implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer blockAmount;
	private AutoBlock[] blocks;
	public Integer getBlockAmount() {
		return blockAmount;
	}
	public void setBlockAmount(Integer blockAmuont) {
		this.blockAmount = blockAmuont;
	}
	public AutoBlock[] getBlocks() {
		return blocks;
	}
	public void setBlocks(AutoBlock[] blocks) {
		this.blocks = blocks;
	}
}
