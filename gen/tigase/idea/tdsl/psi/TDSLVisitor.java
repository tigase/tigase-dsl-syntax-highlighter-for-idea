// This is a generated file. Not intended for manual editing.
package tigase.idea.tdsl.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class TDSLVisitor extends PsiElementVisitor {

  public void visitBean(@NotNull TDSLBean o) {
    visitPsiElement(o);
  }

  public void visitBeanCfg(@NotNull TDSLBeanCfg o) {
    visitPsiElement(o);
  }

  public void visitBeanCfgPropPair(@NotNull TDSLBeanCfgPropPair o) {
    visitPsiElement(o);
  }

  public void visitBeanContent(@NotNull TDSLBeanContent o) {
    visitPsiElement(o);
  }

  public void visitEnvFunction(@NotNull TDSLEnvFunction o) {
    visitPsiElement(o);
  }

  public void visitListValue(@NotNull TDSLListValue o) {
    visitPsiElement(o);
  }

  public void visitProp(@NotNull TDSLProp o) {
    visitPsiElement(o);
  }

  public void visitValue(@NotNull TDSLValue o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
