package tigase.idea.tdsl;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tigase.idea.tdsl.psi.TDSLTypes;

public class TDSLBraceMatcher
		implements PairedBraceMatcher {

	private static BracePair[] PAIRS = {new BracePair(TDSLTypes.LCURLY, TDSLTypes.RCURLY, true),
										new BracePair(TDSLTypes.LPAREN, TDSLTypes.RPAREN, true),
										new BracePair(TDSLTypes.LBRACK, TDSLTypes.RBRACK, true)};

	@NotNull
	@Override
	public BracePair[] getPairs() {
		return PAIRS;
	}

	@Override
	public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType,
												   @Nullable IElementType contextType) {
		return true;
	}

	@Override
	public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
		return openingBraceOffset;
	}
}
