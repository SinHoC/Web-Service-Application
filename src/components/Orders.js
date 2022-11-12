import React from "react";
import jwt from 'jwt-decode';
import { styled, createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import Container from '@mui/material/Container';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Title from './Title';
import Typography from '@mui/material/Typography';



const mdTheme = createTheme();

const Orders = () => {
    if(localStorage.getItem('token') == null){
        return(
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
                            <Grid  container justifyContent="center">
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
    else{
        var profile = localStorage.getItem('token');
        var decode = jwt(profile);
        console.log(decode);
        return(
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
                            <Grid  container justifyContent="center">
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
                                            <Title>Your Account</Title>
                                            <Typography component="p" variant="h5">
                                                Name: {decode.name}
                                            </Typography>
                                            <Typography component="p" variant="h5">
                                                Phone: {decode.phone_number}
                                            </Typography>
                                        </React.Fragment>
                                    </Paper>
                                </Grid>
                            </Grid>
                    </Box>
                </Box>
            </ThemeProvider>
        )
    }
};

export default Orders;