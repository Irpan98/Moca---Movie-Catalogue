package id.itborneo.moca


//@RunWith(RobolectricTestRunner::class)
//@Config(sdk = [Build.VERSION_CODES.P])
class RobolectricActivityTest {
//    private lateinit var activity: MainActivity
//
//    @Before
//    @Throws(Exception::class)
//    fun setUp() {
//        activity = Robolectric.buildActivity(MainActivity::class.java).create().get()
//
//    }

    //    @Test
//    @Throws(Exception::class)
//    fun shouldHaveDefaultMargin() {
////        val textView = activity.findViewById(R.id.hello_textview) as TextView
////        val bottomMargin = (textView.layoutParams as LinearLayout.LayoutParams).bottomMargin
////        assertEquals(5, bottomMargin)
////        val topMargin = (textView.layoutParams as LinearLayout.LayoutParams).topMargin
////        assertEquals(5, topMargin)
////        val rightMargin = (textView.layoutParams as LinearLayout.LayoutParams).rightMargin
////        assertEquals(10, rightMargin)
////        val leftMargin = (textView.layoutParams as LinearLayout.LayoutParams).leftMargin
////        assertEquals(10, leftMargin)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun checkActivityNotNull() {
//        assertNotNull(activity)
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun shouldHaveCorrectAppName() {
//        val hello: String = activity?.resources?.getString(R.string.app_name) ?: ""
//        assertThat(hello, equalTo("Moca Jetpack"))
//    }
//
//
//    @Test
//    @Throws(Exception::class)
//
//    fun homeFragment() {
////        val homeFragment = launchFragmentInContainer<HomeFragment>()
//        val homeFragment = FragmentScenario.launch(HomeFragment::class.java)
//
//        onView(withId(R.id.rv_movies)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//
//        assertNotNull(homeFragment)
//    }

//
//    @Test
//    @Throws(Exception::class)
//    fun buttonClickShouldStartNewActivity() {
////        val button: Button = activity.findViewById(R.id.startNextActivity) as Button
////        button.performClick()
////        val intent: Intent = Shadows.shadowOf(activity).peekNextStartedActivity()
////        assertEquals(
////            RobolectricSecondActivity::class.java.getCanonicalName(), intent.component!!
////                .className
////        )
//    }

//    @Test
//    @Throws(Exception::class)
//    fun testButtonClickShouldShowToast() {
//        val activity: RobolectricActivity =
//            Robolectric.buildActivity(RobolectricActivity::class.java).create().get()
//        val view: Button = activity.findViewById(R.id.showToast) as Button
//        assertNotNull(view)
//        view.performClick()
//        assertThat(ShadowToast.getTextOfLatestToast(), equalTo("Lala"))
//    }
}