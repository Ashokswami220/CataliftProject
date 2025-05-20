package com.example.catalift

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.DirectionsRun
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.SportsEsports
import androidx.compose.material.icons.filled.SportsKabaddi
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri

const val colorUi = 0xFF0D47A1


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MainScreen(paddingValues: PaddingValues) {


    val context = LocalContext.current

    val coverImage = R.drawable.coding_image
    val profileImage = R.drawable.profile3
    val name = "Ashok Swami"
    val rating = 4.8
    val profession = "UI UX Designer and Researcher"
    val summary = """
            Android App Developer with over 1 year of experience in Kotlin and a track record of building 2+ functional mobile
            applications. 
            Skilled in Firebase integration, Jetpack Compose for UI, and implementing clean architecture using MVVM.
""".trimIndent()




    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(paddingValues),
        contentPadding = PaddingValues(bottom = 32.dp)
    ) {
        item {
            Box {
                // Background image
                Image(
                    painter = painterResource(id = coverImage),
                    contentDescription = "Main Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                // Back button with background
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .size(50.dp)
                        .background(Color(colorUi), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }

                // Profile image
                Image(
                    painter = painterResource(id = profileImage),
                    contentDescription = "Overlay Image",
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .offset(x = 20.dp, y = 60.dp)
                        .size(120.dp)
                        .clip(CircleShape)
                        .border(5.dp, Color.White, CircleShape)
                        .fillMaxSize()
                )


            }
        }

        item {
            Spacer(modifier = Modifier.height(60.dp))
        }


        item {
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                // Name and Right Mark
                Row{
                    Text(
                        text = name,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Icon(
                        imageVector = Icons.Default.CheckCircle,
                        contentDescription = null,
                        tint = Color(colorUi),
                        modifier = Modifier.size(34.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Star and Rating
                Row {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null,
                        tint = Color(0xFFFFD700),
                        modifier = Modifier.size(28.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = rating.toString(),
                        fontSize = 18.sp,
                        color = Color.Gray,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }

                Text(
                    text = profession,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 12.dp)
                )

                Row(
                    modifier = Modifier.padding(top = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(1.dp)
                ) {
                    Text(
                        text = "Google",
                        fontWeight = FontWeight.Bold,
                        color = Color(colorUi),
                    )
                    Text(
                        text = " | ",
                        fontSize = 17.sp,
                        color = Color.Gray,
                    )
                    Text(
                        text = "Oxford University",
                        fontWeight = FontWeight.Bold,
                        color = Color(colorUi),
                    )
                    Text(
                        text = " | ",
                        fontSize = 17.sp,
                        color = Color.Gray,
                    )
                    Text(
                        text = "Mechanical Engineering",
                        fontWeight = FontWeight.Bold,
                        color = Color(colorUi),
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            val linkedInUrl = "www.linkedin.com/in/swamiashok220"
                            val intent = Intent(Intent.ACTION_VIEW, linkedInUrl.toUri())
                            try {
                                context.startActivity(intent)
                            } catch (e: Exception) {
                                e.printStackTrace()
                                Toast.makeText(context, "No browser found to open the link", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(colorUi))
                    ) {
                        Text("Connect", color = Color.White)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    OutlinedButton(
                        onClick = { },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(16.dp),
                    ) {
                        Text(text = "Message", color = Color(colorUi))
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))

                Text (
                    text = summary,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black,
                    ),
                )

                Spacer(modifier = Modifier.height(30.dp))




            }
        }
        item{
            Column (
                modifier = Modifier.padding(16.dp),
            ) {
                Interest()
                Profession()
            }
        }





    }



}


@Composable
fun Profession() {
    Column {

        Text(
            text = "Profession",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(18.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Summary : ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(0.3f),
                color = Color(colorUi)
            )
            Text(
                text = "Android App Developer with over 1 year of experience in Kotlin and a track record of building 2+ functional mobile applications.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.weight(0.7f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Skills : ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(0.3f),
                color = Color(colorUi)
            )
            Text(
                text = "Advanced: Java – Expertise in OOP, Collections, Multithreading, Data Structures & Algorithms (Solved 50+ Advanced Problems).\n" +
                        "• \u2060Intermediate: Kotlin – Coroutines, Extension Functions, Jetpack Compose, developed 2+ responsive asynchronous applications.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.weight(0.7f)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Experience : ",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.weight(0.3f),
                color = Color(colorUi)
            )
            Text(
                text = "• Built a simple Notes app using Kotlin and Jetpack Compose, completing the project in about 4 weeks as part of personal learning.\n\n" +
                        "• Performed extensive testing on 5 Android Emulator and real devices to ensure compatibility and stability.\n\n" +
                        "• Developed 2+ Android applications using Kotlin, Jetpack Compose, and Firebase, focusing on performance, responsiveness, and\n\n" +
                        "clean UI/UX design.\n" +
                        "• Gained hands-on experience by building 3+ small-scale projects over the past few months.\n\n" +
                        "• Worked across 3+ different domains, improving my ability to adapt to new environments and develop a well-rounded skill set.\n\n" +
                        "• Diagnosed and fixed application crashes using debugging tools and user feedback, leading to a 25% increase in user retention.\n\n" +
                        "• Conducted usability testing with 10+ users, improving the project’s onboarding experience and increasing conversion rate by 45%.\n\n" +
                        "• Actively using these tools and technologies has steadily improved my skills and confidence by approximately 30–40%.\n\n" +
                        "• Mastered 10+ core Java principles, leading to improved code logic, efficiency, and implementation accuracy.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.weight(0.7f)
            )
        }
    }
}




@Composable
fun Interest(){
    Column {

        Text(
            text = "Interest",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(22.dp))

        InterestList("Music", Icons.Default.MusicNote)
        InterestList("Games", Icons.Default.SportsEsports)
        InterestList("Coding",Icons.Default.Code)
        InterestList("Running", Icons.AutoMirrored.Filled.DirectionsRun)
        InterestList("Sports",Icons.Default.SportsKabaddi)
        InterestList("Designing",Icons.Default.Brush)

    }
}


@Composable
fun InterestList(interest : String, icon : ImageVector) {

    var checked by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(color = colorUi),
                uncheckedColor = Color.Gray,
                checkmarkColor = Color.White
            )
        )

        Text(
            text = interest,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(start = 8.dp)
        )

        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 8.dp)
                .size(24.dp)
        )

    }
}
