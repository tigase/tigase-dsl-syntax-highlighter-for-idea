// This is a generated file. Not intended for manual editing.
package tigase.idea.tdsl.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static tigase.idea.tdsl.psi.TDSLTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import tigase.idea.tdsl.psi.*;

public class TDSLBeanImpl extends ASTWrapperPsiElement implements TDSLBean {

  public TDSLBeanImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TDSLVisitor visitor) {
    visitor.visitBean(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TDSLVisitor) accept((TDSLVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<TDSLBean> getBeanList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TDSLBean.class);
  }

  @Override
  @NotNull
  public List<TDSLProp> getPropList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, TDSLProp.class);
  }

  @Override
  @NotNull
  public PsiElement getBeanName() {
    return findNotNullChildByType(BEANNAME);
  }

}
