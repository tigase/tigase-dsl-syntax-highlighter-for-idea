/*
 * TDSLBlock.java
 *
 * Tigase DSL Syntax Highlighter for IDEA
 * Copyright (C) 2017 "Tigase, Inc." <office@tigase.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 *
 */
package tigase.idea.tdsl;

import com.intellij.formatting.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.TokenType;
import com.intellij.psi.formatter.common.AbstractBlock;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tigase.idea.tdsl.psi.TDSLTypes;

import java.util.ArrayList;
import java.util.List;

public class TDSLBlock extends AbstractBlock {

	private final SpacingBuilder spacingBuilder;

	protected TDSLBlock(@NotNull ASTNode node, @Nullable Wrap wrap, @Nullable Alignment alignment, SpacingBuilder spacingBuilder) {
		super(node, wrap, alignment);
		this.spacingBuilder = spacingBuilder;
	}

	@Nullable
	@Override
	public Spacing getSpacing(@Nullable Block child1, @NotNull Block child2) {
		return spacingBuilder.getSpacing(this, child1, child2);
	}

	@Override
	public boolean isLeaf() {
		return myNode.getFirstChildNode() == null;
	}

	@Override
	protected List<Block> buildChildren() {
		List<Block> blocks = new ArrayList<>();
		ASTNode child = myNode.getFirstChildNode();
		while (child != null) {
//			if (child.getElementType() != TokenType.WHITE_SPACE) {
//				Block block = new TDSLBlock(child, Wrap.createWrap(WrapType.NONE, false), Alignment.createAlignment(), spacingBuilder);
//				blocks.add(block);
//			}
			if (child.getElementType() == TDSLTypes.BEAN) {
				Block block = new TDSLBlock(child, Wrap.createWrap(WrapType.NORMAL, false), Alignment.createAlignment(), spacingBuilder);
				blocks.add(block);
			} else if (child.getElementType() != TokenType.WHITE_SPACE) {
				Block block = new TDSLBlock(child, Wrap.createWrap(WrapType.NORMAL, false), Alignment.createAlignment(), spacingBuilder);
				blocks.add(block);
			}
			child = child.getTreeNext();
		}
		return blocks;
	}

	@Override
	public Indent getIndent() {
		if (myNode.getElementType() == TDSLTypes.PROP || myNode.getElementType() == TDSLTypes.BEAN) {
			ASTNode parent = myNode.getTreeParent();
			if (parent != null && parent.getElementType() == TDSLTypes.BEAN) {
				return Indent.getIndent(Indent.Type.NORMAL, true, true);
			}
		}
		if (myNode.getElementType() == TDSLTypes.COMMENT) {
			return Indent.getAbsoluteNoneIndent();
		}
		return Indent.getNoneIndent();
	}

}
