import * as React from 'react';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import Link from '@mui/material/Link';
import Joined from './Joined';
import { BroncoButton } from './styles';
import Grid from '@mui/material/Grid';
import { modalStyle } from './styles';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { MobileTimePicker } from '@mui/x-date-pickers/MobileTimePicker';
import Modal from '@mui/material/Modal';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import { useForm } from "react-hook-form";
import Paper from '@mui/material/Paper';
import Title from './Title';

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

const createOrder = () => (
  <BroncoButton>
    + Create An Order
  </BroncoButton>
)

function JoinedContent() {
  const [homeLogin, setHomeLogin] = React.useState(false)
  const [orderOpen, setOrderOpen] = React.useState(false)
  const [pickup, setPickup] = React.useState(null)
  const [arrival, setArrival] = React.useState(null)

  const { register, handleSubmit } = useForm();

  const checkLogin = () => {
    if (localStorage.getItem('token') != null) {
      setHomeLogin(true)
    }
    else {
      setHomeLogin(false)
    }
  }

  const addOrder = () => {
    setOrderOpen(true);
  }

  const handleOrderClose = () => {
    setOrderOpen(false);
  }

  React.useEffect(() => {
    if (orderOpen) {
      setPickup(null)
      setArrival(null)
    }
  }, [orderOpen])

  const submitted = (values) => {
    console.log(values)
  }

  window.addEventListener('load', function () {
    checkLogin()
  })

  if (localStorage.getItem('token') == null) {
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
              <Grid item xs={12} md={4} lg={3}>
                <Paper
                  sx={{
                    p: 2,
                    display: 'flex',
                    flexDirection: 'column',
                    height: 'auto',
                  }}
                >
                  <React.Fragment>
                    <Title>You are not signed in.</Title>
                  </React.Fragment>
                </Paper>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </ThemeProvider>
    )
  }
  else {
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
              <Typography component="p" variant="h4">
                Your Joined Orders
              </Typography>
            </Grid>
            <Container maxWidth="lg" sx={{ mt: 2, mb: 4 }}>
              <Joined />
              <Copyright sx={{ pt: 4 }} />
            </Container>
          </Box>
        </Box>
      </ThemeProvider>
    );

  }
}

export default function JoinedPage() {
  return <JoinedContent />;
}
