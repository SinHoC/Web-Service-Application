import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import Menu from '@mui/material/Menu';
import MenuIcon from '@mui/icons-material/Menu';
import Container from '@mui/material/Container';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import Tooltip from '@mui/material/Tooltip';
import MenuItem from '@mui/material/MenuItem';
import AdbIcon from '@mui/icons-material/Adb';
import { Link } from 'react-router-dom';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import logo from './logo.png';
import { BroncoButton } from './styles';
import jwt from 'jwt-decode';

const pages = ['Orders','JoinedOrders', 'Account'];
const settings = ['Profile', 'Account', 'Dashboard', 'Logout'];

// Change for toolbar color
const darkTheme = createTheme({
    palette: {
        primary: {
            main: '#dcddde',
        },
    },
});

function ResponsiveAppBar() {
  const [anchorElNav, setAnchorElNav] = React.useState(null);
  const [anchorElUser, setAnchorElUser] = React.useState(null);
  const [login, setLogin] = React.useState(false);


  const handleOpenNavMenu = (event) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleCloseNavMenu = () => {
    setAnchorElNav(null);
  };

  const handleCloseUserMenu = () => {
    setAnchorElUser(null);
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
            var tempToken = window.location.hash;
            console.log(tempToken)
            var idToken = tempToken.substring(tempToken.indexOf("=") + 1, tempToken.indexOf("&"));
            console.log(idToken)
            localStorage.setItem('token', idToken);

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
        var decode = jwt(token);
        console.log(decode);
        logIn();
    }
}

window.addEventListener('load', function(){
    tryLogIn()
})

  return (
    <ThemeProvider theme={darkTheme}>
        <AppBar position="static">
        <Container maxWidth="xl">
            <Toolbar disableGutters>
            <div class='col-md-4'>
                <img src={logo} width={100} height={100} alt="logo" />
            </div>
            <div class='col-md-4'>
            <Typography
                variant="h3"
                noWrap
                sx={{
                mr: 2,
                display: { xs: 'none', md: 'flex' },
                fontFamily: 'Roboto',
                fontWeight: 700,
                letterSpacing: '.3rem',
                color: 'inherit',
                textDecoration: 'none',
                }}
            >
                Billy's Bites
            </Typography>
            </div>
            <Typography
                variant="h6"
                noWrap
                component="a"
                href="/"
                sx={{
                mr: 2,
                display: { xs: 'none', md: 'flex' },
                fontFamily: 'inherit',
                fontWeight: 700,
                letterSpacing: '.3rem',
                color: 'inherit',
                textDecoration: 'none',
                }}
            >
                HOME
            </Typography>

            <Box sx={{ flexGrow: 1, display: { xs: 'flex', md: 'none' } }}>
                <IconButton
                size="large"
                aria-label="account of current user"
                aria-controls="menu-appbar"
                aria-haspopup="true"
                onClick={handleOpenNavMenu}
                color="inherit"
                >
                <MenuIcon />
                </IconButton>
                <Menu
                id="menu-appbar"
                anchorEl={anchorElNav}
                anchorOrigin={{
                    vertical: 'bottom',
                    horizontal: 'left',
                }}
                keepMounted
                transformOrigin={{
                    vertical: 'top',
                    horizontal: 'left',
                }}
                open={Boolean(anchorElNav)}
                onClose={handleCloseNavMenu}
                sx={{
                    display: { xs: 'block', md: 'none' },
                }}
                >
                {pages.map((page) => (
                    <MenuItem key={page} onClick={handleCloseNavMenu}>
                    <Typography textAlign="center">
                        <Link to={`/${page}`}>{page}</Link>
                    </Typography>
                    </MenuItem>
                ))}
                </Menu>
            </Box>
            <Typography
                variant="h5"
                noWrap
                component="a"
                href=""
                sx={{
                mr: 2,
                display: { xs: 'flex', md: 'none' },
                flexGrow: 1,
                fontFamily: 'monospace',
                fontWeight: 700,
                letterSpacing: '.3rem',
                color: 'inherit',
                textDecoration: 'none',
                }}
            >
                HOME
            </Typography>
            <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
                {pages.map((page) => (
                <Button
                    key={page}
                    onClick={handleCloseNavMenu}
                    sx={{ my: 2, color: 'white', display: 'block' }}
                >
                    <Link to={`/${page}`}>{page}</Link>
                </Button>
                ))}
            </Box>

            <Box sx={{ flexGrow: 0 }}>
            {login
                ? <BroncoButton onClick={logOut}
                variant='contained'>Log Out</BroncoButton>
                : <BroncoButton href="https://billysbites.auth.us-west-2.amazoncognito.com/login?client_id=2kugeanvc4vklvudpiob4ska79&response_type=token&scope=email+openid+phone+profile&redirect_uri=http://localhost:3000/"
                variant='contained'>Log In</BroncoButton>
            }
                {/* <Tooltip title="Open settings">
                <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
                    <Avatar alt="Remy Sharp" src="/static/images/avatar/2.jpg" />
                </IconButton>
                </Tooltip> */}
                <Menu
                sx={{ mt: '45px' }}
                id="menu-appbar"
                anchorEl={anchorElUser}
                anchorOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
                keepMounted
                transformOrigin={{
                    vertical: 'top',
                    horizontal: 'right',
                }}
                open={Boolean(anchorElUser)}
                onClose={handleCloseUserMenu}
                >
                {settings.map((setting) => (
                    <MenuItem key={setting} onClick={handleCloseUserMenu}>
                    <Typography textAlign="center">{setting}</Typography>
                    </MenuItem>
                ))}
                </Menu>
            </Box>
            </Toolbar>
        </Container>
        </AppBar>
    </ThemeProvider>
  );
}
export default ResponsiveAppBar;
