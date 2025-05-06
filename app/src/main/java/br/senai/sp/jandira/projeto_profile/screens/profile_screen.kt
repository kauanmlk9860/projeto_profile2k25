package br.senai.sp.jandira.projeto_profile.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.projeto_profile.R
import br.senai.sp.jandira.projeto_profile.ui.theme.ProjetoProfileTheme

@Composable
fun ProfileScreen() {
    Column(modifier = Modifier.fillMaxSize().background(Color.White)) {

        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF4B2CA4), shape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp))
                .padding(top = 32.dp, bottom = 24.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    Spacer(Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.avatar), // Substitua pela sua imagem
                    contentDescription = "Avatar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(CircleShape)
                )
                Text("Jenny Wilson", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Sr. UI/UX Designer", color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    ActionButton(Icons.Default.Email, stringResource(R.string.email))
                    ActionButton(Icons.Default.Call, stringResource(R.string.call))
                    ActionButton(Icons.Default.Share, stringResource(R.string.whatsapp))
                    ActionButton(Icons.Default.Star, stringResource(R.string.favorite))
                }
            }
        }

        // Email Section
        InfoSection(
            icon = Icons.Default.Email,
            title = stringResource(R.string.email),
            content = {
                Text(stringResource(R.string.official), fontSize = 12.sp, color = Color.Gray)
                Text("michael.mitc@example.com", fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(stringResource(R.string.personal), fontSize = 12.sp, color = Color.Gray)
                Text("michael@example.com", fontSize = 14.sp)
            }
        )

        // Phone Section
        InfoSection(
            icon = Icons.Default.Call,
            title = stringResource(R.string.phone_number),
            content = {
                Text(stringResource(R.string.mobile), fontSize = 12.sp, color = Color.Gray)
                Text("(209) 555-0104", fontSize = 14.sp)
            }
        )

        // Team Section
        InfoSectionWithArrow(
            icon = Icons.Default.Home,
            title = stringResource(R.string.team),
            subtitle = stringResource(R.string.project_operation_team)
        )

        // Leads By Section
        InfoSectionWithArrow(
            icon = Icons.Default.Person,
            title = stringResource(R.string.leads_by),
            subtitle = stringResource(R.string.darrell_steward)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Add to Contact + Share
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ContactButton(Icons.Default.Person, stringResource(R.string.add_to_contact))
            Icon(Icons.Default.Share, contentDescription = "Share", tint = Color(0xFF4B2CA4))
        }
    }
}

@Composable
fun ActionButton(icon: ImageVector, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .background(Color(0x33FFFFFF), shape = RoundedCornerShape(12.dp))
            .padding(12.dp)
    ) {
        Icon(icon, contentDescription = label, tint = Color.White)
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, color = Color.White, fontSize = 12.sp)
    }
}

@Composable
fun InfoSection(icon: ImageVector, title: String, content: @Composable () -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(icon, contentDescription = title, tint = Color(0xFF4B2CA4))
            Spacer(modifier = Modifier.width(8.dp))
            Text(title, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}

@Composable
fun InfoSectionWithArrow(icon: ImageVector, title: String, subtitle: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Default.SupervisorAccount, contentDescription = title, tint = Color(0xFF4B2CA4))
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = subtitle, color = Color.Gray, fontSize = 14.sp)
        }
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "Arrow",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .background(Color(0xFF4B2CA4), shape = CircleShape)
                .padding(6.dp)
        )
    }
}

@Composable
fun ContactButton(icon: ImageVector, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(RoundedCornerShape(24.dp))
            .background(Color(0xFFF5F5F5))
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Icon(icon, contentDescription = label, tint = Color(0xFF4B2CA4))
        Spacer(modifier = Modifier.width(8.dp))
        Text(label, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProjetoProfileTheme {
        ProfileScreen()
    }
}