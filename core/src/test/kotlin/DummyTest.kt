import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class DummyTest : StringSpec({

    "this is a dummy test" {
        true shouldBe true
    }
})
