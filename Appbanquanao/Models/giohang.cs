//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Appbanquanao.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class giohang
    {
        public int idgh { get; set; }
        public Nullable<int> idtk { get; set; }
        public Nullable<int> idsp { get; set; }
        public int sl { get; set; }
        public string chon { get; set; }
        public string giax1 { get; set; }
        public int tongtien { get; set; }
        public string ghichu { get; set; }
    
        public virtual san_pham san_pham { get; set; }
    }
}
