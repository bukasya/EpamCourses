package collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class CustomListsTest {
    private List<String> list;

    public CustomListsTest(List<String> list) {
        this.list = list;
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new Object[]{
                new CustomArrayList(),
                new CustomLinkedList()
        });
    }

    @Before
    public void init() {
        list.clear();
    }

    @Test
    public void testThatNewListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testThatListNotEmptyAfterAddingElement() {
        list.add("aaaa");
        assertThat(list.isEmpty(), is(false));
    }

    @Test
    public void testThatListContainsElementThatWeAddedBefore() {
        String value = "bbb";

        list.add(value);

        assertTrue(list.contains(value));
    }

    @Test
    public void testThatListNotContainsElementThatWasntAddedToList() throws Exception {
        list.add("fff");
        assertFalse(list.contains("ccc"));
    }

    @Test
    public void testThatListContainsNullIfItWasAdded() {

        list.add(null);

        assertTrue(list.contains(null));
    }

    @Test
    public void testThatListNotContainsNullIfItWasNotAdded() {
        list.add("fff");
        assertFalse(list.contains(null));
    }

    @Test
    public void testThatListsSizeIsDynamic() throws Exception {
        int size = 50;

        for (int i = 0; i < size; i++) {
            list.add(String.valueOf(i));
        }

        assertThat(list.size(), is(size));
    }

    @Test
    public void testThatWeCanGetElementByIndex() {

        fillList();

        assertThat(list.get(1), is(equalTo("aa1a")));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatWeCantGetElementByIndexMoreThenSize() throws Exception {

        fillList();

        list.get(list.size());
    }

    @Test
    public void testThatWeCanRemoveExistedElementFromList() throws Exception {
        fillList();

        list.remove("ssss");

        assertFalse("contains", list.contains("ssss"));
    }

    @Test
    public void testThatWeCanDeleteElementByIndex() throws Exception {
        fillList();

        String removed = list.remove(2);

        assertFalse(list.contains("aa2a"));
        assertThat(removed, is(equalTo("aa2a")));
    }

    @Test
    public void testThatWeCanDeleteLastElement() throws Exception {
        fillList();

        int prevSize = list.size();

        list.remove(list.size() - 1);

        assertFalse(list.contains("999"));
        assertThat(list.size(), is(equalTo(prevSize - 1)));
    }

    @Test
    public void testThatWeCantDeleteNonExistentElement() throws Exception {
        fillList();

        assertFalse(list.remove("sadasdasd"));
    }

    @Test
    public void testThatWeCanGetIndexOfExistingElement() throws Exception {
        fillList();

        assertThat(list.indexOf("aa1a"), is(equalTo(1)));
    }

    @Test (expected = NoSuchElementException.class)
    public void testThatWeCanNotGetIndexOfNonExistingElement() throws Exception {
        fillList();

        list.indexOf("NonExistingElement");
    }

    @Test
    public void testThatWeCanGetLastIndexOfExistingElement() throws Exception {
        fillList();
        list.add("aa1a");
        list.add("aa1a");

        assertThat(list.lastIndexOf("aa1a"), is(equalTo(list.size()-1)));
    }

    @Test (expected = NoSuchElementException.class)
    public void testThatWeCanNotGetLastIndexOfNonExistingElement() throws Exception {
        fillList();

        list.indexOf("NonExistingElement");
    }

    @Test
    public void testThatWeCanAddElementAtSpecifiedIndex() throws Exception {
        int index = 2;
        String element = "pppp";

        fillList();

        list.add(index, element);

        assertThat(list.indexOf(element), is(equalTo(index)));
    }

    @Test
    public void testThatWeCanSetValueForElementAtExistingIndex() throws Exception {
        fillList();
        int index = 2;
        String element = "222";

        list.set(index, element);

        assertThat(list.indexOf(element), is(equalTo(index)));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testThatWeCanNotSetValueForElementAtNonExistingIndex() throws Exception {
        fillList();
        int index = 12;
        String element = "We can't do this";

        list.set(index, element);
    }

    @Test
    public void testThatWeCanGetExistingSublist() throws Exception {
        fillList();

        List<String> newList = list.subList(1, 3);

        assertTrue(newList.contains("aa1a"));
        assertTrue(newList.contains("ssss"));
        assertFalse(newList.contains("aa0a"));
        assertFalse(newList.contains("aa3a"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testThatWeCanNotGetSublistWhereFromIndexIsMoreThanToIndex() throws Exception {
        fillList();

        List<String> newList = list.subList(4, 3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testThatWeCanNotGetSublistWhereAnyIndexIsNegative() throws Exception {
        fillList();

        List<String> newList = list.subList(-1, 3);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testThatWeCanNotGetSublistWhereAnyIndexIsMoreThanArraySize() throws Exception {
        fillList();

        List<String> newList = list.subList(2, 15);
    }

    //fill list with 10 elements to check capacity increase
    private void fillList() {
        list.add("aa0a");
        list.add("aa1a");
        list.add("aa2a");
        list.add("ssss");
        list.add("aa3a");
        list.add("aa4a");
        list.add("666");
        list.add("777");
        list.add("888");
        list.add("999");
    }
}