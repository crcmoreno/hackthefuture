package dev.reto.hackthefuture;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

    @Test
    void servicesAndRepositoriesShouldNotDependOnWebLayer() {
        JavaClasses importedClasses = new ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("dev.reto.hackthefuture");

        noClasses()
            .that()
            .resideInAnyPackage("dev.reto.hackthefuture.service..")
            .or()
            .resideInAnyPackage("dev.reto.hackthefuture.repository..")
            .should()
            .dependOnClassesThat()
            .resideInAnyPackage("..dev.reto.hackthefuture.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses);
    }
}
