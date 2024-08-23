import com.Emazon.stock_mircoservice.domine.exception.EmptyFieldException;
import com.Emazon.stock_mircoservice.domine.exception.InvalidLengthMaxDescription;
import com.Emazon.stock_mircoservice.domine.exception.InvalidLengthMaxName;
import com.Emazon.stock_mircoservice.domine.models.Category;
import com.Emazon.stock_mircoservice.domine.utils.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void shouldThrowExceptionWhenNameIsEmpty() {
        // Act & Assert
        assertThrows(EmptyFieldException.class, () -> new Category("", "A valid description"));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionIsEmpty() {
        // Act & Assert
        assertThrows(EmptyFieldException.class, () -> new Category("A valid name", ""));
    }

    @Test
    void shouldThrowExceptionWhenNameExceedsMaxLength() {
        // Arrange
        String longName = "A".repeat(Constants.LENGTH_MAX_NAME + 1);

        // Act & Assert
        assertThrows(InvalidLengthMaxName.class, () -> new Category(longName, "A valid description"));
    }

    @Test
    void shouldThrowExceptionWhenDescriptionExceedsMaxLength() {
        // Arrange
        String longDescription = "A".repeat(Constants.LENGTH_MAX_DESCRIPTION + 1);

        // Act & Assert
        assertThrows(InvalidLengthMaxDescription.class, () -> new Category("A valid name", longDescription));
    }

    @Test
    void shouldCreateCategoryWithValidNameAndDescription() {
        // Act
        Category category = new Category("Valid Name", "Valid Description");

        // Assert
        assertEquals("Valid Name", category.getName());
        assertEquals("Valid Description", category.getDescription());
    }

    @Test
    void shouldCreateCategoryWithIdNameAndDescription() {
        // Act
        Category category = new Category(1L, "Valid Name", "Valid Description");

        // Assert
        assertEquals(1L, category.getId());
        assertEquals("Valid Name", category.getName());
        assertEquals("Valid Description", category.getDescription());
    }
}
