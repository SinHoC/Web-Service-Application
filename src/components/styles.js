import Button from '@mui/material/Button'
import TextField from '@mui/material/TextField';
import { createTheme } from '@mui/material/styles'
import { styled } from '@mui/material/styles';
import { green } from '@mui/material/colors';


export const BroncoButton = styled(Button)(({ theme }) => ({
    color: 'white',
    backgroundColor: green[500],
    '&:hover': {
      backgroundColor: green[700],
    },
  }));

export const modalStyle = {
    position: 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    bgcolor: 'background.paper',
    border: '2px solid #000',
    boxShadow: 24,
    p: 4,
    '& .MuiTextField-root': { m: 1, width: '25ch' },
  };