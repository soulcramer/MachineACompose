package app.soulcramer.machineacompose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Calculate
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.savedinstancestate.savedInstanceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.VectorAsset
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.ui.tooling.preview.Preview
import app.soulcramer.machineacompose.ui.AddClothe
import app.soulcramer.machineacompose.ui.Calculator
import app.soulcramer.machineacompose.ui.MyCLothes
import app.soulcramer.machineacompose.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This app draws behind the system bars, so we want to handle fitting system windows
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MacApp()
        }
    }
}

@Composable
fun MacApp() {
    MacTheme {
        ProvideDisplayInsets {
            val (currentSection, setCurrentSection) = savedInstanceState { HomeSections.AddClothe }
            val navItems = HomeSections.bottomNavSections
            Scaffold(
                topBar = { MacTopAppBar() },
                bottomBar = {
                    MacBottomNavigationView(
                        currentSection = currentSection,
                        onSectionSelected = setCurrentSection,
                        navItems
                    )
                },
                floatingActionButton = {
                    val section = HomeSections.AddClothe
                    FloatingActionButton(onClick = { setCurrentSection(section) }, icon = { Icon(section.icon) })
                },
                floatingActionButtonPosition = FabPosition.Center,
                isFloatingActionButtonDocked = true
            ) { innerPadding ->
                val modifier = Modifier.padding(innerPadding)
                Crossfade(currentSection) { section ->
                    when (section) {
                        HomeSections.Calulator -> Calculator(modifier)
//                        ImeAction.Search -> Search(onSnackSelected, modifier)
                        HomeSections.AddClothe -> AddClothe(modifier)
                        HomeSections.MyClothes -> MyCLothes(modifier)

                    }
                }
            }
        }
    }
}

@Composable
fun MacTopAppBar() {
    TopAppBar(
        modifier = Modifier.statusBarsHeightPlus(56.dp),
        title = {
            Text(
                modifier = Modifier.statusBarsPadding(),
                text = "Machine à Compose"
            )
        }
    )
}

@Composable
private fun MacBottomNavigationView(
    currentSection: HomeSections,
    onSectionSelected: (HomeSections) -> Unit,
    sections: List<HomeSections>
) {
    Surface(
        color = MaterialTheme.colors.primarySurface,
        contentColor = contentColorFor(MaterialTheme.colors.primarySurface),
        elevation = 8.dp,
    ) {
        Row(
            Modifier.fillMaxWidth().navigationBarsHeightPlus(BottomNavHeight).navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            sections.forEach {
                BottomNavigationItem(
                    icon = { Icon(it.icon) },
                    selected = it == currentSection,
                    label = { Text(text = it.title) },
                    onClick = { onSectionSelected(it) }
                )
            }
        }
    }
}


private val BottomNavHeight = 56.dp

private enum class HomeSections(
    val title: String,
    val icon: VectorAsset
) {
    Calulator("Home", Icons.Rounded.Home),
    MyClothes("My clothe", Icons.Rounded.List),
    AddClothe("Add clothe", Icons.Rounded.Add),
    Process("Process", Icons.Rounded.Calculate);

    companion object {
        val bottomNavSections = listOf(Calulator, MyClothes)
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MacApp()
}
