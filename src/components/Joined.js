import * as React from 'react';
import Link from '@mui/material/Link';
import Typography from '@mui/material/Typography';
import Title from './Title';
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Button from '@mui/material/Button'
import TextField from '@mui/material/TextField';
import { createTheme } from '@mui/material/styles'
import { styled } from '@mui/material/styles';
import { green } from '@mui/material/colors';
import AddIcon from '@mui/icons-material/Add';
import IconButton from '@mui/material/IconButton';
import { useState, useEffect } from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import LocalPhoneIcon from '@mui/icons-material/LocalPhone';
import { BroncoButton } from './styles';
import { modalStyle } from './styles';
import Axios from 'axios';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Container from '@mui/material/Container';




function preventDefault(event) {
  event.preventDefault();
}

export default function Deposits() {

  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => {
    setCounter(1);
    setOpen(false);
  };
  const [counter, setCounter] = useState(1);

  const handleAddTextField = () => {
    setCounter(counter + 1);
    console.log(counter);
  };

  const [orders, setOrderData] = useState([{}])

  // Get loggin info
  var profile = localStorage.getItem('token');
  var decode = jwt(profile);
  console.log(decode);
  var namePhone = decode.name
  
  useEffect(() => {
    // CHANGE LINK
    // DEPLOYMENT: billysbitescpp.com:8080/api/order1
    // DEVELOPMENT: http://ec2-54-202-111-166.us-west-2.compute.amazonaws.com:8080/api/order1
    Axios.get('http://localhost:8080/api/getJoined', { crossDomain: true }).then((res) => {
      console.log(res.data);
      setOrderData(res.data);
    })
  }, [])

  return (
    <Grid container spacing={3}>
      {orders.map((order) => (
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
              <Title>{order.name}</Title>
              <Typography color="text.secondary" sx={{ flex: 1 }}>
                <LocalPhoneIcon />
                {order.phoneNumber}
              </Typography>
              <Typography component="p" variant="h4">
                {order.restaurant}
              </Typography>
              <Typography color="text.secondary" sx={{ flex: 1 }}>
                Expected Pickup: {order.pickup}
              </Typography>
              <Typography color="text.secondary" sx={{ flex: 1 }}>
                Expected Arrival: {order.arrival}
              </Typography>
              <Typography color="text.secondary" sx={{ flex: 2 }}>
                Meeting Location: {order.location}
              </Typography>
              <div>
                <BroncoButton onClick={handleOpen} variant='contained'>Join Order</BroncoButton>
                <Modal
                  open={open}
                  onClose={handleClose}
                  aria-labelledby="modal-modal-title"
                  aria-describedby="modal-modal-description"
                >
                  <Box sx={modalStyle} component='form'>
                    <Typography id="modal-modal-title" variant="h6" component="h2">
                      Enter item to order:
                    </Typography>
                    {Array.from(Array(counter)).map((c, index) => {
                      return (
                        <div>
                          <TextField label='Enter item...' variant='outlined' sx={{ flex: 2 }} />
                        </div>
                      )
                    })}
                    <ListItemButton aria-label="add" onClick={handleAddTextField}>
                      <ListItemIcon>
                        <AddIcon />
                      </ListItemIcon>
                      <ListItemText primary="Add more items" />
                    </ListItemButton>
                    <BroncoButton variant='contained'>Submit</BroncoButton>
                  </Box>
                </Modal>
              </div>
            </React.Fragment>
          </Paper>
        </Grid>
      ))}

    </Grid>

  );
}
