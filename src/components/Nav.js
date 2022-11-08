import * as React from 'react';
import { styled, createTheme, ThemeProvider } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import MuiDrawer from '@mui/material/Drawer';
import Box from '@mui/material/Box';
import MuiAppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Typography from '@mui/material/Typography';
import Divider from '@mui/material/Divider';
import IconButton from '@mui/material/IconButton';
import MenuIcon from '@mui/icons-material/Menu';
import ChevronLeftIcon from '@mui/icons-material/ChevronLeft';
import { mainListItems } from './listItems';
import logo from './logo.png';
import { BroncoButton } from './styles';
import jwt from 'jwt-decode';

const drawerWidth = 240;

const AppBar = styled(MuiAppBar, {
    shouldForwardProp: (prop) => prop !== 'open',
})(({ theme, open }) => ({
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['width', 'margin'], {
        easing: theme.transitions.easing.sharp,
        duration: theme.transitions.duration.leavingScreen,
    }),
    ...(open && {
        marginLeft: drawerWidth,
        width: `calc(100% - ${drawerWidth}px)`,
        transition: theme.transitions.create(['width', 'margin'], {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen,
        }),
    }),
}));

const Drawer = styled(MuiDrawer, { shouldForwardProp: (prop) => prop !== 'open' })(
    ({ theme, open }) => ({
      '& .MuiDrawer-paper': {
        position: 'relative',
        whiteSpace: 'nowrap',
        width: drawerWidth,
        transition: theme.transitions.create('width', {
          easing: theme.transitions.easing.sharp,
          duration: theme.transitions.duration.enteringScreen,
        }),
        boxSizing: 'border-box',
        ...(!open && {
          overflowX: 'hidden',
          transition: theme.transitions.create('width', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.leavingScreen,
          }),
          width: theme.spacing(7),
          [theme.breakpoints.up('sm')]: {
            width: theme.spacing(9),
          },
        }),
      },
    }),
  );

// Change for toolbar color
const darkTheme = createTheme({
    palette: {
        primary: {
            main: '#dcddde',
        },
    },
});

// Change for toolbar color
const greenTheme = createTheme({
    palette: {
        primary: {
            main: '#15c232',
        },
    },
});

export default function Nav() {
    const [login, setLogin] = React.useState(false);
    const [open, setOpen] = React.useState(true);

    const toggleDrawer = () => {
        setOpen(!open);
    };

    const logOut = () => {
        setLogin(!login);
        localStorage.clear();
        window.location.href = "http://localhost:3000/"
    }

    const logIn = () => {
        setLogin(!login);
    }

    const tryLogIn = () => {
        if (localStorage.getItem('token') == null) {
            // If local storage empty AND has in URL is not empty
            if (window.location.hash != null && window.location.hash != "") {
                localStorage.setItem('token', window.location.hash);
                var token = localStorage.getItem('token');
                console.log(token);
                var idToken = token.substring(token.indexOf("=") + 1, token.indexOf("&"));
                console.log(idToken);

                var decode = jwt(idToken);
                console.log(decode);

                // Set state that user is logged in
                logIn();
            }
        }
        // Else hash in URL is empty, but local storage has token
        // The user logged in, did not log out, and reloaded the page w/o id token in URL
        else {
            var token = localStorage.getItem('token');
            console.log(token);
            var idToken = token.substring(token.indexOf("=") + 1, token.indexOf("&"));
            console.log(idToken);

            var decode = jwt(idToken);
            console.log(decode);
            logIn();
        }
    }


    window.onload = function () {
        tryLogIn()
    }

    return (
        <>
            <ThemeProvider theme={darkTheme}>
                <AppBar position="absolute" open={open}>
                    <Toolbar
                        sx={{
                            pr: '24px', // keep right padding when drawer closed
                        }} theme={greenTheme}
                    >
                        <IconButton
                            edge="start"
                            color="inherit"
                            aria-label="open drawer"
                            onClick={toggleDrawer}
                            sx={{
                                marginRight: '36px',
                                ...(open && { display: 'none' }),
                            }}
                        >
                            <MenuIcon />
                        </IconButton>
                        <div class='col-md-4'>
                            <img src={logo} width={100} height={100} alt="logo" />
                        </div>
                        <Typography
                            component="h1"
                            variant="h6"
                            color="inherit"
                            noWrap
                            sx={{ flexGrow: 1 }}
                        >
                            Billy's Bites
                        </Typography>
                        {login
                            ? <BroncoButton onClick={logOut}
                                variant='contained'>Log Out</BroncoButton>
                            : <BroncoButton href="https://billysbites.auth.us-west-2.amazoncognito.com/login?client_id=2kugeanvc4vklvudpiob4ska79&response_type=token&scope=email+openid+phone+profile&redirect_uri=http://localhost:3000/"
                                variant='contained'>Log In</BroncoButton>
                        }
                    </Toolbar>
                </AppBar>
            </ThemeProvider>
            <Drawer variant="permanent" open={open}>
                <Toolbar
                    sx={{
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'flex-end',
                        px: [5],
                    }}
                >
                    <IconButton onClick={toggleDrawer}>
                        <ChevronLeftIcon />
                    </IconButton>
                </Toolbar>
                <Divider />
                <List component="nav">
                    {/* {mainListItems} */}
                    <Divider sx={{ my: 3 }} />
                    {mainListItems}
                </List>
            </Drawer>
        </>
    )

}