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
import { useState } from 'react';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import LocalPhoneIcon from '@mui/icons-material/LocalPhone';
import { BroncoButton } from './styles';
import { modalStyle } from './styles';



function preventDefault(event) {
  event.preventDefault();
}

export default function Deposits2() {

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

  return (
    <React.Fragment>
      <Title>Yu Sun</Title>
      <Typography color="text.secondary" sx={{ flex: 1 }}>
        <LocalPhoneIcon/>
        111-222-3333
      </Typography>
      <Typography component="p" variant="h4">
        Koji Ramen
      </Typography>
      <Typography color="text.secondary" sx={{ flex: 1 }}>
        Expected Pickup: 2:30 P.M
      </Typography>
      <Typography color="text.secondary" sx={{ flex: 1 }}>
        Expected Arrival: 2:45 P.M
      </Typography>
      <Typography color="text.secondary" sx={{ flex: 2 }}>
        Meeting Location: 1nd floor library
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

  );
}
