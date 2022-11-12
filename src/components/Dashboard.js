import * as React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Link from '@mui/material/Link';
import Deposits from './Deposits';
import { BroncoButton } from './styles';
import Grid from '@mui/material/Grid';

function Copyright(props) {
  return (
    <Typography variant="body2" color="text.secondary" align="center" {...props}>
      {'Copyright © '}
      <Link color="inherit" href="https://mui.com/">
        What's that?
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

const mdTheme = createTheme();

const createOrder = () =>(
  <BroncoButton>
    + Create An Order
   </BroncoButton>
)

function HomeContent() {
  const[homeLogin, setHomeLogin] = React.useState(false)

  const checkLogin = () => {
    if(localStorage.getItem('token') != null){
      setHomeLogin(true)
    }
    else{
      setHomeLogin(false)
    }
  }

  window.addEventListener('load', function(){
    checkLogin()
  })

  return (
    <ThemeProvider theme={mdTheme}>
      <Box sx={{ display: 'flex' }}>
        <CssBaseline />
        <Box
          component="main"
          sx={{
            backgroundColor: (theme) =>
              theme.palette.mode === 'light'
                ? theme.palette.grey[100]
                : theme.palette.grey[900],
            flexGrow: 1,
            height: '100vh',
            overflow: 'auto',
          }}
        >
          <Toolbar />
          <Grid container justifyContent="center">
            {homeLogin
            ? <BroncoButton>+ Create An Order</BroncoButton>
            : <></>
            }
          </Grid>
          <Container maxWidth="lg" sx={{ mt: 2, mb: 4 }}>
            <Deposits />
          <Copyright sx={{ pt: 4 }} />
          </Container>
        </Box>
      </Box>
    </ThemeProvider>
  );
}

export default function Home() {
  return <HomeContent />;
}
