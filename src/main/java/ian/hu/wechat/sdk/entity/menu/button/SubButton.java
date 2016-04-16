package ian.hu.wechat.sdk.entity.menu.button;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 子菜单
 */
public class SubButton extends AbstractButton {

    private static final long serialVersionUID = 6910110003783707954L;
    @JsonProperty("sub_button")
    protected List<AbstractButton> subButtons = new ArrayList<>();

    public SubButton() {
    }

    public SubButton(String name) {
        setName(name);
    }

    public List<AbstractButton> getSubButtons() {
        return Collections.unmodifiableList(subButtons);
    }

    public void setSubButtons(List<AbstractButton> subButtons) {
        this.subButtons = subButtons;
    }

    public Boolean add(AbstractButton button) {
        if (subButtons.size() >= 5) {
            return false;
        }
        subButtons.add(button);
        return true;
    }

    @Override
    public String toString() {
        return "SubButton{" +
                "name=" + getName() +
                ",subButtons=" + subButtons +
                '}';
    }
}
