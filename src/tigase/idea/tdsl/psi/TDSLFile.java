/*
 * TDSLFile.java
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
package tigase.idea.tdsl.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tigase.idea.tdsl.TDSLFileType;
import tigase.idea.tdsl.TDSLLanguage;

import javax.swing.*;

public class TDSLFile extends PsiFileBase {

	public TDSLFile(@NotNull FileViewProvider viewProvider) {
		super(viewProvider, TDSLLanguage.INSTANCE);
	}

	@NotNull
	@Override
	public FileType getFileType() {
		return TDSLFileType.INSTANCE;
	}

	@Override
	public String toString() {
		return "Tigase DSL File";
	}

	@Nullable
	@Override
	public Icon getIcon(int flags) {
		return super.getIcon(flags);
	}
}
